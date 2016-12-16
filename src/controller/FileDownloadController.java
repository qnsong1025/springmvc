package controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 2016/12/15.
 */
@Controller
@RequestMapping(value = "/file")
public class FileDownloadController {

    /**
     * 文件下载
     * @Description:
     * @param fileName
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/download")
    public @ResponseBody
    String downloadFile(@RequestParam("fileName") String fileName,
                        HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String result;
        try {
            String temp=URLDecoder.decode(URLDecoder.decode(fileName,"UTF-8"),"UTF-8");
            fileName=URLDecoder.decode(fileName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String,Object> map= new HashMap<String,Object>();
        if (fileName != null) {
            String realPath = request.getServletContext().getRealPath(
                    "/down_files/");
            File file = new File(realPath, fileName);
            if (file.exists()) {
                // 清空response
                response.reset();
                response.setContentType("application/force-download");// 设置强制下载不打开
//                response.addHeader("Content-Disposition",
//                        "attachment;fileName=" + fileName);// 设置文件名 ,这样设置会出现乱码
                //下面一行转码之后下载的文件不会出现中文乱码
                response.addHeader("Content-Disposition", "attachment;fileName="+new String(fileName.getBytes("gbk"),"iso-8859-1"));
                response.addHeader("Content-Length", "" + file.length());
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    map.put("result","success");
                } catch (Exception e) {
                    map.put("result","success");
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        result=String.valueOf( JSONObject.fromObject(map));
        return result;
    }

}
