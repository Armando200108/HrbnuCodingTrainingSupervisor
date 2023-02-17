# 测试用密钥库及证书

## keystore

密钥库详情：

- 密码为：simrobot
- 别名：simrobotkey

配置内容：

- 您的名字与姓氏是什么?
  - Armando Li
- 您的组织单位名称是什么?
  - SimRobot
- 您的组织名称是什么?
  - SimRobot
- 您所在的城市或区域名称是什么?
  - Harbin
- 您所在的省/市/自治区名称是什么?
  - Heilongjiang/Harbin
- 该单位的双字母国家/地区代码是什么?
  - 86/0451
- CN=Armando Li, OU=SimRobot, O=SimRobot, L=Harbin, ST=Heilongjiang/Harbin, C=86/0451

keytool -genkeypair -alias simrobotkey -keyalg RSA -keysize 2048 -validity 365 -keystore simrobotKey.keystore

参数解释：
- storepass  keystore文件存储密码，不加这个参数会在后面要求你输入密码
- keypass  私钥加解密密码
- alias  实体别名(包括证书私钥)
- dname  证书个人信息
- keyalg  采用公钥算法，默认是DSA，这里采用RSA
- keysize  密钥长度(DSA算法对应的默认算法是sha1withDSA，不支持2048长度，此时需指定RSA)
- validity  有效期
- keystore  指定keystore文件储存位置


## jks

说明：

密码统一为：simrobot

别名：simrobotjks

keytool -genkeypair -alias simrobotjks -keyalg RSA -validity 365 -keystore simrobotJks.jks

## keystore格式导出

keytool -exportcert -keystore simrobotKey.keystore -file simrobotKey.cer -alias simrobotkey

 参数解释：
- -export  表示证书导出操作
- -keystore  指定秘钥库文件
- -file  指定导出文件路径
- -storepass  输入密码
- -rfc  指定以Base64编码格式输出

## 打印cer证书

Keytool -printcert -file simrobotKey.cer
