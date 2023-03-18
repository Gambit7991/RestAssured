package api.utils;

import api.pojos.AuthPojo;
import api.pojos.BoardPojo;

public class Generator {

    private static final String KEY = "e8da38c3519426b4773937a9ebd073c8";
    private static final String TOKEN = "ATTA63eb8825cd586f0f4dc5e6d1cdc0950c1f28d62607d554df517542eaca77e82dDBED9C9B";

    public static BoardPojo generateBoardPojo(){
        BoardPojo result = new BoardPojo();
        result.setName("Hello world");
        return result;
    }

    public static AuthPojo getAuth(){
        return new AuthPojo(KEY, TOKEN);
    }
}
