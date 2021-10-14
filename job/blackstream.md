黑灯流
api接口: timeline/similar
入口: 点击视频动态卡片 
调用接口: recommendation/oasis_general_recommend.json
    该接口同时被以下三个地方调用
        频道流(见下方详细描述)
        status/timeline (入口: 点击图片动态卡片)
        recommend/feedback_general_recommend (入口: (黑灯流+兴趣漫游中)点赞,点击评论按钮,点击wow按钮均调用)


频道流
api接口: timeline/discovery + timeline/discovery_and_card(ins排版,已经被淘汰非常久了)
入口: 首页的推荐tab,搜索页的壁纸/头像tab
调用接口: 
    同城频道调用余红组接口(略)
    其他频道调用平台接口: recommendation/oasis_general_recommend.json
        该接口同时被以下三个地方调用
            黑灯流(见上方描述)
            status/timeline (入口: 点击图片动态卡片)
            recommend/feedback_general_recommend (入口: (黑灯流+兴趣漫游中)点赞,点击评论按钮,点击wow按钮均调用)
