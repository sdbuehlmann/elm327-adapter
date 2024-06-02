package ch.donkeycode.obd2.pids.models;

import ch.donkeycode.common.ArrayHelper;
import ch.donkeycode.common.BitHelper;
import ch.donkeycode.obd2.pids.ParameterID;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

@Value
@Builder
@Slf4j
public class SupportedPIDsReport {
    @NonNull
    @Singular
    Set<ParameterID<?>> supportedPids;

    @NonNull
    @Singular
    Set<ParameterID<?>> unsupportedPids;

    public static Function<List<Byte>, SupportedPIDsReport> deserializer(ParameterID<?>... pids) {
        return bytes -> {
            val builder = SupportedPIDsReport.builder();

            BitHelper
                    .streamBits(bytes)
                    .forEach(entry -> {
                        val relatedPid = ArrayHelper.tryGet(pids, entry.getBitIndex());
                        if (entry.getBit() > 0) {
                            // supported
                            relatedPid.ifPresentOrElse(
                                    builder::supportedPid,
                                    () -> log.error("Unknown supported PID at index {} ignored", entry.getBitIndex())
                            );
                        } else {
                            // unsupported
                            relatedPid.ifPresentOrElse(
                                    builder::unsupportedPid,
                                    () -> log.error("Unknown but also unsupported PID at index {} ignored", entry.getBitIndex())
                            );
                        }
                    });

            return builder.build();
        };
    }
}
