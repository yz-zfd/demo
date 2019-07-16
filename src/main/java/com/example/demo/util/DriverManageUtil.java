package com.example.demo.util;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author zfd
 * 日期 2019/07/02
 */
public class DriverManageUtil {
    /**
     * 此方法用于解析表单数据，并找出文件（二进制数据）
     * @param map：用于接收解析请求对象后的数据
     * @param request：请求对象
     * @throws FileUploadException：可能出现文件上传异常
     */
    public synchronized static void parseFileFormUtil(Map<String,Object> map, HttpServletRequest request) throws Exception {
        ServletFileUpload fileUpload = new ServletFileUpload(new DiskFileItemFactory());
        @SuppressWarnings("unchecked")
        List<FileItem> list = fileUpload.parseRequest(request);
        for (FileItem item:list){
            if(item.isFormField()){
                //需要将birthday的字符串转为日期格式
                if("birthday".equals(item.getFieldName())){
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    long l = sdf.parse(item.getString("utf-8")).getTime();
                    map.put(item.getFieldName(),new Date(l));
                    continue;
                }
                if("marital_status".equals(item.getFieldName())){
                    boolean ms="已婚".equals(item.getString("utf-8"));
                    map.put(item.getFieldName(),ms);
                    continue;
                }
                map.put(item.getFieldName(),item.getString("utf-8"));
            }else{
                //保存图片到本地,若是扩展名为空，则为未更改图片（前端判断了后缀的）
                String fileExt =FilenameUtils.getExtension(item.getName()).trim();
                if(!"".equals(fileExt)){
                    String fileName = UUID.randomUUID().toString() .concat(".") .concat(fileExt);
                    String path=request.getSession().getServletContext().getRealPath("/driverImg/")+fileName;
                    item.write(new File(path));
                    map.put(item.getFieldName(),fileName);
                }else {
                    map.put(item.getFieldName(),"default.png");
                }
            }
        }
    }


    /*public synchronized static void mapToDriverEncapsula(Map<String,String> map, DriverInformation driver) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.populate(driver,map);
    }*/
}
