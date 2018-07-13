package com.miraj.service;

import com.miraj.model.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.miraj.model.CollectionRequest;
import com.miraj.model.UserModelList;
import com.miraj.serviceImpl.CollectionServiceImpl;
import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@RestController
public class CollectionService {

    @Autowired
    CollectionServiceImpl collectionServiceImpl;

    @Autowired
    FreeMarkerConfigurer freemarkerConfigure;

    @RequestMapping(value = "/donors", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ApiResponse getDonors(@RequestBody CollectionRequest collectionRequest) {
        if (collectionRequest != null) {
            UserModelList userModelList = collectionServiceImpl.getFilteredData(collectionRequest);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("users", userModelList.getUserModelList());
            ApiResponse apiResponse = new ApiResponse();
            String template = null;

            try {
                template = FreeMarkerTemplateUtils
                        .processTemplateIntoString(freemarkerConfigure.getConfiguration().getTemplate("filter_donate.ftl"), map);
                apiResponse.setResult(template);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return apiResponse;
        }
        return null;
    }

}
