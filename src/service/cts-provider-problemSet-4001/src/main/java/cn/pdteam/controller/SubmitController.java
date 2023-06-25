package cn.pdteam.controller;

import cn.pdteam.dao.StatusMapper;
import cn.pdteam.pojo.CommonResult;
import cn.pdteam.pojo.problemSet.entity.Status;
import cn.pdteam.pojo.problemSet.enums.StatusResult;
import cn.pdteam.pojo.problemSet.request.SubmitCodeRequest;
import com.alibaba.fastjson2.JSON;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/submit")
public class SubmitController {
    @Autowired
    StatusMapper statusMapper;
    @Autowired
    DefaultMQProducer defaultMQProducer;

    private static final String TOPIC = "cts-submit-code";

    @PostMapping("/code")
    public CommonResult<?> submitCode(@RequestBody SubmitCodeRequest request) throws MQClientException {
        request.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        CommonResult<?> result;
        Status status = new Status(0, request.getUserId(), request.getProblemId(),
                request.getContestId(), StatusResult.PENDING, null, null, null,
                request.getLanguage(), LocalDateTime.now());
        statusMapper.addStatus(status);
//        DefaultMQProducer defaultMQProducer=new DefaultMQProducer("cts-problem");
//        defaultMQProducer.setNamesrvAddr("192.168.200.131:9876");
//        defaultMQProducer.start();
        Message message = new Message(TOPIC, request.getLanguage().getLanguage(), request.getId(), JSON.toJSONBytes(request));
        try {
            SendResult sendResult = defaultMQProducer.send(message);
            result = CommonResult.success(sendResult.getSendStatus());
        } catch (RemotingException | MQBrokerException | InterruptedException e) {
            e.printStackTrace();
            status.setResult(StatusResult.SYSTEM_ERROR);
            result = new CommonResult<>(500, "失败！", e.getMessage());
        }
        return result;
    }
}
