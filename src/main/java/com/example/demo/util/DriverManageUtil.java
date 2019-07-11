package com.example.demo.util;


import com.example.demo.domain.DriverInformation;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
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
     * @param map
     * @param request
     * @throws FileUploadException
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
                    Long l = sdf.parse(item.getString("utf-8")).getTime();
                    map.put(item.getFieldName(),new Date(l));
                    continue;
                }
                map.put(item.getFieldName(),item.getString("utf-8"));
            }else{
                //保存图片到本地
                String fileName = UUID.randomUUID().toString() .concat(".") .concat(FilenameUtils.getExtension(item.getName()));
                String path=request.getSession().getServletContext().getRealPath("/driverImg/")+fileName;
                item.write(new File(path));
                map.put(item.getFieldName(),path);
            }
        }
    }


    /*public synchronized static void mapToDriverEncapsula(Map<String,String> map, DriverInformation driver) throws InvocationTargetException, IllegalAccessException {
        BeanUtils.populate(driver,map);
    }*/
}
