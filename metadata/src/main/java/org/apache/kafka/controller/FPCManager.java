package org.apache.kafka.controller;

import org.apache.kafka.clients.admin.AlterConfigOp;
import org.apache.kafka.common.Reconfigurable;
import org.apache.kafka.common.config.ConfigResource;
import org.apache.kafka.common.metadata.KVRecord;
import org.apache.kafka.common.protocol.ApiMessage;

import java.util.Map;


public interface FPCManager extends Reconfigurable {
    String TIME_KEY = "createdTimestamp";

    String installId();

    boolean checkLicense();

    boolean startScheduleCheck();

    boolean replay(KVRecord record);

    boolean replayLicenseConfig(ApiMessage record);

    boolean recordExists();

    boolean updateDynamicConfig(Map<ConfigResource, Map<String, Map.Entry<AlterConfigOp.OpType, String>>> configChanges);

    boolean legacyUpdateDynamicConfig(Map<ConfigResource, Map<String, String>> newConfigs);
}
