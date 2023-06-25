FROM centos:centos7.9.2009
LABEL authors="Armando"
MAINTAINER armando<l.dzh@163.com>
ENV LANG zh_CN.UTF-8
ENV JUDGER_DIR ~/judger
ENV CODE_DIR ~/judger/code
ENV DATA_DIR ~/judger/data
ENV OUTPUT_DIR ~/judger/output
ENV INPUT_DIR ~/judger/input

WORKDIR /root/judger/code

VOLUME $CODE_DIR $DATA_DIR $OUTPUT_DIR $INPUT_DIR
RUN yum install rpm -y  \
    & yum install gcc-c++ -y
ADD jdk-17_linux-x64_bin.rpm /usr/local/java/
RUN rpm -ivh /usr/local/java/jdk-17_linux-x64_bin.rpm
RUN mkdir ~/judger/data
RUN mkdir ~/judger/output
RUN mkdir ~/judger/input


ENTRYPOINT ["java","Main"]
