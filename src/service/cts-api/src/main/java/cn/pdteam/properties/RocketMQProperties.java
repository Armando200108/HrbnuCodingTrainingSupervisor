package cn.pdteam.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


public class RocketMQProperties {
    private String namesrvAddr;
    private String producerGroup;
    private String consumerGroup;
    private String topic;
    private String tag;
    private String instanceName;
    private String accessKey;
    private String secretKey;
    private String sendMsgTimeoutMillis;
    private String maxMessageSize;
    private String retryTimesWhenSendFailed;
    private String retryTimesWhenSendAsyncFailed;
    private String retryAnotherBrokerWhenNotStoreOK;
    private String compressMsgBodyOverHowmuch;
    private String maxReconsumeTimes;
    private String consumeThreadMin;
    private String consumeThreadMax;
    private String adjustThreadPoolNumsThreshold;
    private String consumeMessageBatchMaxSize;
    private String consumeTimeout;
    private String pullThresholdForQueue;
    private String pullThresholdSizeForQueue;
    private String pullThresholdForTopic;
    private String pullThresholdSizeForTopic;
    private String consumeMessageBatchMaxBufferSize;
    private String pullInterval;
    private String consumeConcurrentlyMaxSpan;
    private String pullBatchSize;
    private String pullBatchInterval;
    private String consumeMessageBatchMaxRetryTimes;
    private String pullIntervalCommit;
    private String brokerSuspendMaxTimeMillis;
    private String consumerTimeoutMillisWhenSuspend;
    private String unitMode;
    private String postSubscriptionWhenPull;
    private String maxRebalanceDelay;
    private String retryDelayLevelWhenNextConsume;
    private String maxTimeConsumeContinuously;
    private String accessChannel;
    private String pollNameServerInterval;
    private String heartbeatBrokerInterval;
    private String persistConsumerOffsetInterval;
    private String unitName;
    private String vipChannelEnabled;
    private String useTLS;
    private String sslContext;
    private String namesrvDomain;
    private String namesrvAddrList;
    private String clientCallbackExecutorThreads;
    private String pollTimeoutMillis;
    private String clientIP;
    private String unitModeClient;
    private String clientChannelMaxIdleTimeSeconds;
    private String clientAsyncSemaphoreValue;
    private String clientOnewaySemaphoreValue;
    private String clientCloseSocketIfTimeout;
    private String clientSocketSndBufSize;
    private String clientSocketRcvBufSize;
    private String clientSocketMaxFrameLength;
    private String clientSocketMaxIdleTimeMillis;
    private String clientSocketMaxRetryAttempts;
    private String clientSocketAsyncSemaphoreValue;
    private String clientSocketOneway;

    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    public RocketMQProperties setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
        return this;
    }

    public String getProducerGroup() {
        return producerGroup;
    }

    public RocketMQProperties setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
        return this;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public RocketMQProperties setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
        return this;
    }

    public String getTopic() {
        return topic;
    }

    public RocketMQProperties setTopic(String topic) {
        this.topic = topic;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public RocketMQProperties setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getInstanceName() {
        return instanceName;
    }

    public RocketMQProperties setInstanceName(String instanceName) {
        this.instanceName = instanceName;
        return this;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public RocketMQProperties setAccessKey(String accessKey) {
        this.accessKey = accessKey;
        return this;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public RocketMQProperties setSecretKey(String secretKey) {
        this.secretKey = secretKey;
        return this;
    }

    public String getSendMsgTimeoutMillis() {
        return sendMsgTimeoutMillis;
    }

    public RocketMQProperties setSendMsgTimeoutMillis(String sendMsgTimeoutMillis) {
        this.sendMsgTimeoutMillis = sendMsgTimeoutMillis;
        return this;
    }

    public String getMaxMessageSize() {
        return maxMessageSize;
    }

    public RocketMQProperties setMaxMessageSize(String maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
        return this;
    }

    public String getRetryTimesWhenSendFailed() {
        return retryTimesWhenSendFailed;
    }

    public RocketMQProperties setRetryTimesWhenSendFailed(String retryTimesWhenSendFailed) {
        this.retryTimesWhenSendFailed = retryTimesWhenSendFailed;
        return this;
    }

    public String getRetryTimesWhenSendAsyncFailed() {
        return retryTimesWhenSendAsyncFailed;
    }

    public RocketMQProperties setRetryTimesWhenSendAsyncFailed(String retryTimesWhenSendAsyncFailed) {
        this.retryTimesWhenSendAsyncFailed = retryTimesWhenSendAsyncFailed;
        return this;
    }

    public String getRetryAnotherBrokerWhenNotStoreOK() {
        return retryAnotherBrokerWhenNotStoreOK;
    }

    public RocketMQProperties setRetryAnotherBrokerWhenNotStoreOK(String retryAnotherBrokerWhenNotStoreOK) {
        this.retryAnotherBrokerWhenNotStoreOK = retryAnotherBrokerWhenNotStoreOK;
        return this;
    }

    public String getCompressMsgBodyOverHowmuch() {
        return compressMsgBodyOverHowmuch;
    }

    public RocketMQProperties setCompressMsgBodyOverHowmuch(String compressMsgBodyOverHowmuch) {
        this.compressMsgBodyOverHowmuch = compressMsgBodyOverHowmuch;
        return this;
    }

    public String getMaxReconsumeTimes() {
        return maxReconsumeTimes;
    }

    public RocketMQProperties setMaxReconsumeTimes(String maxReconsumeTimes) {
        this.maxReconsumeTimes = maxReconsumeTimes;
        return this;
    }

    public String getConsumeThreadMin() {
        return consumeThreadMin;
    }

    public RocketMQProperties setConsumeThreadMin(String consumeThreadMin) {
        this.consumeThreadMin = consumeThreadMin;
        return this;
    }

    public String getConsumeThreadMax() {
        return consumeThreadMax;
    }

    public RocketMQProperties setConsumeThreadMax(String consumeThreadMax) {
        this.consumeThreadMax = consumeThreadMax;
        return this;
    }

    public String getAdjustThreadPoolNumsThreshold() {
        return adjustThreadPoolNumsThreshold;
    }

    public RocketMQProperties setAdjustThreadPoolNumsThreshold(String adjustThreadPoolNumsThreshold) {
        this.adjustThreadPoolNumsThreshold = adjustThreadPoolNumsThreshold;
        return this;
    }

    public String getConsumeMessageBatchMaxSize() {
        return consumeMessageBatchMaxSize;
    }

    public RocketMQProperties setConsumeMessageBatchMaxSize(String consumeMessageBatchMaxSize) {
        this.consumeMessageBatchMaxSize = consumeMessageBatchMaxSize;
        return this;
    }

    public String getConsumeTimeout() {
        return consumeTimeout;
    }

    public RocketMQProperties setConsumeTimeout(String consumeTimeout) {
        this.consumeTimeout = consumeTimeout;
        return this;
    }

    public String getPullThresholdForQueue() {
        return pullThresholdForQueue;
    }

    public RocketMQProperties setPullThresholdForQueue(String pullThresholdForQueue) {
        this.pullThresholdForQueue = pullThresholdForQueue;
        return this;
    }

    public String getPullThresholdSizeForQueue() {
        return pullThresholdSizeForQueue;
    }

    public RocketMQProperties setPullThresholdSizeForQueue(String pullThresholdSizeForQueue) {
        this.pullThresholdSizeForQueue = pullThresholdSizeForQueue;
        return this;
    }

    public String getPullThresholdForTopic() {
        return pullThresholdForTopic;
    }

    public RocketMQProperties setPullThresholdForTopic(String pullThresholdForTopic) {
        this.pullThresholdForTopic = pullThresholdForTopic;
        return this;
    }

    public String getPullThresholdSizeForTopic() {
        return pullThresholdSizeForTopic;
    }

    public RocketMQProperties setPullThresholdSizeForTopic(String pullThresholdSizeForTopic) {
        this.pullThresholdSizeForTopic = pullThresholdSizeForTopic;
        return this;
    }

    public String getConsumeMessageBatchMaxBufferSize() {
        return consumeMessageBatchMaxBufferSize;
    }

    public RocketMQProperties setConsumeMessageBatchMaxBufferSize(String consumeMessageBatchMaxBufferSize) {
        this.consumeMessageBatchMaxBufferSize = consumeMessageBatchMaxBufferSize;
        return this;
    }

    public String getPullInterval() {
        return pullInterval;
    }

    public RocketMQProperties setPullInterval(String pullInterval) {
        this.pullInterval = pullInterval;
        return this;
    }

    public String getConsumeConcurrentlyMaxSpan() {
        return consumeConcurrentlyMaxSpan;
    }

    public RocketMQProperties setConsumeConcurrentlyMaxSpan(String consumeConcurrentlyMaxSpan) {
        this.consumeConcurrentlyMaxSpan = consumeConcurrentlyMaxSpan;
        return this;
    }

    public String getPullBatchSize() {
        return pullBatchSize;
    }

    public RocketMQProperties setPullBatchSize(String pullBatchSize) {
        this.pullBatchSize = pullBatchSize;
        return this;
    }

    public String getPullBatchInterval() {
        return pullBatchInterval;
    }

    public RocketMQProperties setPullBatchInterval(String pullBatchInterval) {
        this.pullBatchInterval = pullBatchInterval;
        return this;
    }

    public String getConsumeMessageBatchMaxRetryTimes() {
        return consumeMessageBatchMaxRetryTimes;
    }

    public RocketMQProperties setConsumeMessageBatchMaxRetryTimes(String consumeMessageBatchMaxRetryTimes) {
        this.consumeMessageBatchMaxRetryTimes = consumeMessageBatchMaxRetryTimes;
        return this;
    }

    public String getPullIntervalCommit() {
        return pullIntervalCommit;
    }

    public RocketMQProperties setPullIntervalCommit(String pullIntervalCommit) {
        this.pullIntervalCommit = pullIntervalCommit;
        return this;
    }

    public String getBrokerSuspendMaxTimeMillis() {
        return brokerSuspendMaxTimeMillis;
    }

    public RocketMQProperties setBrokerSuspendMaxTimeMillis(String brokerSuspendMaxTimeMillis) {
        this.brokerSuspendMaxTimeMillis = brokerSuspendMaxTimeMillis;
        return this;
    }

    public String getConsumerTimeoutMillisWhenSuspend() {
        return consumerTimeoutMillisWhenSuspend;
    }

    public RocketMQProperties setConsumerTimeoutMillisWhenSuspend(String consumerTimeoutMillisWhenSuspend) {
        this.consumerTimeoutMillisWhenSuspend = consumerTimeoutMillisWhenSuspend;
        return this;
    }

    public String getUnitMode() {
        return unitMode;
    }

    public RocketMQProperties setUnitMode(String unitMode) {
        this.unitMode = unitMode;
        return this;
    }

    public String getPostSubscriptionWhenPull() {
        return postSubscriptionWhenPull;
    }

    public RocketMQProperties setPostSubscriptionWhenPull(String postSubscriptionWhenPull) {
        this.postSubscriptionWhenPull = postSubscriptionWhenPull;
        return this;
    }

    public String getMaxRebalanceDelay() {
        return maxRebalanceDelay;
    }

    public RocketMQProperties setMaxRebalanceDelay(String maxRebalanceDelay) {
        this.maxRebalanceDelay = maxRebalanceDelay;
        return this;
    }

    public String getRetryDelayLevelWhenNextConsume() {
        return retryDelayLevelWhenNextConsume;
    }

    public RocketMQProperties setRetryDelayLevelWhenNextConsume(String retryDelayLevelWhenNextConsume) {
        this.retryDelayLevelWhenNextConsume = retryDelayLevelWhenNextConsume;
        return this;
    }

    public String getMaxTimeConsumeContinuously() {
        return maxTimeConsumeContinuously;
    }

    public RocketMQProperties setMaxTimeConsumeContinuously(String maxTimeConsumeContinuously) {
        this.maxTimeConsumeContinuously = maxTimeConsumeContinuously;
        return this;
    }

    public String getAccessChannel() {
        return accessChannel;
    }

    public RocketMQProperties setAccessChannel(String accessChannel) {
        this.accessChannel = accessChannel;
        return this;
    }

    public String getPollNameServerInterval() {
        return pollNameServerInterval;
    }

    public RocketMQProperties setPollNameServerInterval(String pollNameServerInterval) {
        this.pollNameServerInterval = pollNameServerInterval;
        return this;
    }

    public String getHeartbeatBrokerInterval() {
        return heartbeatBrokerInterval;
    }

    public RocketMQProperties setHeartbeatBrokerInterval(String heartbeatBrokerInterval) {
        this.heartbeatBrokerInterval = heartbeatBrokerInterval;
        return this;
    }

    public String getPersistConsumerOffsetInterval() {
        return persistConsumerOffsetInterval;
    }

    public RocketMQProperties setPersistConsumerOffsetInterval(String persistConsumerOffsetInterval) {
        this.persistConsumerOffsetInterval = persistConsumerOffsetInterval;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public RocketMQProperties setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public String getVipChannelEnabled() {
        return vipChannelEnabled;
    }

    public RocketMQProperties setVipChannelEnabled(String vipChannelEnabled) {
        this.vipChannelEnabled = vipChannelEnabled;
        return this;
    }

    public String getUseTLS() {
        return useTLS;
    }

    public RocketMQProperties setUseTLS(String useTLS) {
        this.useTLS = useTLS;
        return this;
    }

    public String getSslContext() {
        return sslContext;
    }

    public RocketMQProperties setSslContext(String sslContext) {
        this.sslContext = sslContext;
        return this;
    }

    public String getNamesrvDomain() {
        return namesrvDomain;
    }

    public RocketMQProperties setNamesrvDomain(String namesrvDomain) {
        this.namesrvDomain = namesrvDomain;
        return this;
    }

    public String getNamesrvAddrList() {
        return namesrvAddrList;
    }

    public RocketMQProperties setNamesrvAddrList(String namesrvAddrList) {
        this.namesrvAddrList = namesrvAddrList;
        return this;
    }

    public String getClientCallbackExecutorThreads() {
        return clientCallbackExecutorThreads;
    }

    public RocketMQProperties setClientCallbackExecutorThreads(String clientCallbackExecutorThreads) {
        this.clientCallbackExecutorThreads = clientCallbackExecutorThreads;
        return this;
    }

    public String getPollTimeoutMillis() {
        return pollTimeoutMillis;
    }

    public RocketMQProperties setPollTimeoutMillis(String pollTimeoutMillis) {
        this.pollTimeoutMillis = pollTimeoutMillis;
        return this;
    }

    public String getClientIP() {
        return clientIP;
    }

    public RocketMQProperties setClientIP(String clientIP) {
        this.clientIP = clientIP;
        return this;
    }

    public String getUnitModeClient() {
        return unitModeClient;
    }

    public RocketMQProperties setUnitModeClient(String unitModeClient) {
        this.unitModeClient = unitModeClient;
        return this;
    }

    public String getClientChannelMaxIdleTimeSeconds() {
        return clientChannelMaxIdleTimeSeconds;
    }

    public RocketMQProperties setClientChannelMaxIdleTimeSeconds(String clientChannelMaxIdleTimeSeconds) {
        this.clientChannelMaxIdleTimeSeconds = clientChannelMaxIdleTimeSeconds;
        return this;
    }

    public String getClientAsyncSemaphoreValue() {
        return clientAsyncSemaphoreValue;
    }

    public RocketMQProperties setClientAsyncSemaphoreValue(String clientAsyncSemaphoreValue) {
        this.clientAsyncSemaphoreValue = clientAsyncSemaphoreValue;
        return this;
    }

    public String getClientOnewaySemaphoreValue() {
        return clientOnewaySemaphoreValue;
    }

    public RocketMQProperties setClientOnewaySemaphoreValue(String clientOnewaySemaphoreValue) {
        this.clientOnewaySemaphoreValue = clientOnewaySemaphoreValue;
        return this;
    }

    public String getClientCloseSocketIfTimeout() {
        return clientCloseSocketIfTimeout;
    }

    public RocketMQProperties setClientCloseSocketIfTimeout(String clientCloseSocketIfTimeout) {
        this.clientCloseSocketIfTimeout = clientCloseSocketIfTimeout;
        return this;
    }

    public String getClientSocketSndBufSize() {
        return clientSocketSndBufSize;
    }

    public RocketMQProperties setClientSocketSndBufSize(String clientSocketSndBufSize) {
        this.clientSocketSndBufSize = clientSocketSndBufSize;
        return this;
    }

    public String getClientSocketRcvBufSize() {
        return clientSocketRcvBufSize;
    }

    public RocketMQProperties setClientSocketRcvBufSize(String clientSocketRcvBufSize) {
        this.clientSocketRcvBufSize = clientSocketRcvBufSize;
        return this;
    }

    public String getClientSocketMaxFrameLength() {
        return clientSocketMaxFrameLength;
    }

    public RocketMQProperties setClientSocketMaxFrameLength(String clientSocketMaxFrameLength) {
        this.clientSocketMaxFrameLength = clientSocketMaxFrameLength;
        return this;
    }

    public String getClientSocketMaxIdleTimeMillis() {
        return clientSocketMaxIdleTimeMillis;
    }

    public RocketMQProperties setClientSocketMaxIdleTimeMillis(String clientSocketMaxIdleTimeMillis) {
        this.clientSocketMaxIdleTimeMillis = clientSocketMaxIdleTimeMillis;
        return this;
    }

    public String getClientSocketMaxRetryAttempts() {
        return clientSocketMaxRetryAttempts;
    }

    public RocketMQProperties setClientSocketMaxRetryAttempts(String clientSocketMaxRetryAttempts) {
        this.clientSocketMaxRetryAttempts = clientSocketMaxRetryAttempts;
        return this;
    }

    public String getClientSocketAsyncSemaphoreValue() {
        return clientSocketAsyncSemaphoreValue;
    }

    public RocketMQProperties setClientSocketAsyncSemaphoreValue(String clientSocketAsyncSemaphoreValue) {
        this.clientSocketAsyncSemaphoreValue = clientSocketAsyncSemaphoreValue;
        return this;
    }

    public String getClientSocketOneway() {
        return clientSocketOneway;
    }

    public RocketMQProperties setClientSocketOneway(String clientSocketOneway) {
        this.clientSocketOneway = clientSocketOneway;
        return this;
    }
}
