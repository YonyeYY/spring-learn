package web.app.server;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.springframework.stereotype.Service;
import web.app.facde.IZXingService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

@Service("ZxingService")
public class ZXingImpl implements IZXingService {

    public HttpServletResponse getRCode(HttpServletResponse resp){
        int width = 300;
        int height = 300;
        String type = "png";
        String content = "http://www.baidu.com";

// 定义二维码的配置，使用HashMap
        HashMap hints = new HashMap();
// 字符集，内容使用的编码
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
// 容错等级，H、L、M、Q
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
// 边距，二维码距离边的空白宽度
        hints.put(EncodeHintType.MARGIN, 2);

        try {
            // 生成二维码对象，传入参数：内容、码的类型、宽高、配置
            BitMatrix bitMatrix =  new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

            OutputStream stream = resp.getOutputStream();
            // 生成二维码，传入二维码对象、生成图片的格式、生成的路径
            MatrixToImageWriter.writeToStream(bitMatrix,type ,stream);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resp;
    }
}
