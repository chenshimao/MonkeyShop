package servlet.user;

import util.CodeUtil;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CodeServlet", value = "/getcode")
public class CodeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = CodeUtil.generateCodeAndPic();

        // 将四位数字的验证码保存到Session中。
        HttpSession session = req.getSession();
        session.setAttribute("code", codeMap.get("code").toString());
        System.out.println("这是生成验证码==="+codeMap.get("code").toString());

        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", -1);

        resp.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}