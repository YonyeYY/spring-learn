package web.app.facde;

import javax.servlet.http.HttpServletResponse;

public interface IZXingService {

    HttpServletResponse getRCode(HttpServletResponse resp);

}
