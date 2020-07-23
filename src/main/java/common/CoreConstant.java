package common;

import com.typesafe.config.Config;

public class CoreConstant {

    private static Config conf;

    static {
        conf = Configs.newBuilder()
                .withResource("automation.conf")
                .withResource("automation." + Env.get().getName() + ".conf")
                .build();
    }

    public static final String GAMELIST_HOST = conf.getString("localhost.url");
    public static final String GAMELIST_API = conf.getString("gamelist.api");

    public static final String QC_COCCOC_URL_LOGIN = conf.getString("qcCocCoc.url");
    public static final String FACEBOOK_URL_LOGIN = conf.getString("facebook.url");
    public static final String BLOG_HOST = conf.getString("localhost.url");
    public static final String BLOG_API_USERINFO = conf.getString("blog.api.user");
    public static final String BLOG_API_AUTHEN = conf.getString("blog.api.authen");
    public static final String BLOG_API_BLOG = conf.getString("blog.api.blog");


}
