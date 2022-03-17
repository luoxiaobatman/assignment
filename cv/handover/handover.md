## 交接

#### 微博种草同步绿洲
微博种草发动态的时候, 同步发绿洲动态

基础逻辑: task消费微博相关方的kafka, 调用我的service接口, 再由service调用api接口发绿洲动态

对接产品: 郝红叶

细节:
* service
    - com/weibo/oasis/service/client/impl/WeiboZhongcaoClient.java
    - com/weibo/oasis/service/service/weibo/impl/WeiboZhongcaoServiceImpl.java
    - com/weibo/oasis/service/controller/weibo/WeiboZhongcaoController.java
    - com/weibo/oasis/service/service/weibo/impl/WeiboZhongcaoServiceImpl.java
    - etc...
* api(status.py#create)


#### 绿洲发博同步消息箱
与微博消息箱合作, 绿洲发博的时候, 微博app消息箱同步展示

基础逻辑: 根据规则写入消息箱的消息通道(一种mcq实现), 用户访问消息箱的时候, 回调绿洲接口

对接方: 郝红叶, 微博消息箱团队

细节:
* service
  - com/weibo/oasis/service/controller/weibo/WeiboMessageBoxController.java
  - com/weibo/oasis/service/service/weibo/impl/WeiboMessageBoxImpl.java
  - etc...
* task
   - 包 com.weibo.oasis.task.business.weibomessagebox 下面的所有类
* api(status.py#create) 

#### 图片视频下载
用户支付水滴下载图片视频

细节:
* api(picture.py)
* service
  - com/weibo/oasis/service/controller/pictureDownload/PictureDownloadController.java
  - 包 com.weibo.oasis.service.service.pictureDownload 下面的所有类

#### 反垃圾
与新浪反垃圾部门合作, 通过调用他们的接口, 完成反垃圾.

基础逻辑: 用户上行(发动态, 发评论等)调用反垃圾接口, 包装接口返回值, 传给客户端做对用的提示.

对接方: 微博反垃圾团队

细节: api的所有上行接口

#### 微博橱窗
与微博feed流合作, 在微博feed流展示绿洲的橱窗

基础逻辑: 发动态, 分享动态到微博, 调用微博发动态接口

注意: 分享是通过短链接口weibo_short_url, 获取到短链后把url放到文本中, 通过到微博这种形式解析橱窗的.

细节: 
* api
  - status.py#create
  - daoliu.py

#### 各种流 以及 调用微博基础架构, 关系等的相关接口
共有代码, 各个小组各个开发人员业务耦合, 部分逻辑有我的一部分.
* 搜索页部分
* 关注流部分, 分带card和不带card的版本, 不带card应该没人用了
* 关系
  - 发私信的互关好友
  - 
* 推荐, 
  - 有趣的人(youquderen)
  - 注册推荐关注(create_by_tags)

#### 立个flag
创建一种特殊的动态, 除了动态本身外, 包含看好(不好看)的业务,缓存,和持久化, 以及幂等的重试机制

基础逻辑: 和发布动态相似, 发布动态成功后, 会执行flag动态相关逻辑, 建立好基础数据, 等待上行(看好/不看好)和下行(返回看好不看好数量)

细节: 
* service
  - 包 com.weibo.oasis.service.service.flag 下的所有类
  - com/weibo/oasis/service/controller/flag/FlagStatsController.java
  - com/weibo/oasis/service/controller/flag/FlagUserInteractController.java
* api
  - flag.py
  - status.py#create


#### 用户绿洲设置, 隐私的用户设置部分
这是绿洲所有用户个人的设置

基础逻辑: 上行/下行, 上行更改设置, 下行拉取设置. 同时有批量拉取用户的相关接口供调用

细节:
* api
  - user.py#get_lz_settings, user.py#set_lz_settings
  - friend_chain.py#get_privacy, friend_chain.py#set_privacy
* service
  - com/weibo/oasis/service/controller/user/UserSettingsController.java
  - com/weibo/oasis/service/service/user/impl/UserSettingsServiceImpl.java

#### 活动运营位
运营后台配置活动, 用户线上看到活动

基础逻辑: 运营配置好活动, 添加各种过滤条件, 线上用户准实时地看到活动细节

细节: 
* ui
* admin
* service
  - operation_content相关, 杨谦你当时重构过去的
* api
  - activity.py

#### 用户反馈
简单的crud, 用户发送反馈, 储存反馈, 管理后台统一展示和回复反馈
api: feedback.py

#### 第三方商品
这个和杨宾一起做的, 他非常熟悉