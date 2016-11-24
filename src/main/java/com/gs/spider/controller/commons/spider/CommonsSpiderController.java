package com.gs.spider.controller.commons.spider;

import com.gs.spider.controller.AsyncGatherBaseController;
import com.gs.spider.model.commons.Webpage;
import com.gs.spider.model.utils.ResultBundle;
import com.gs.spider.model.utils.ResultListBundle;
import com.gs.spider.service.AsyncGatherService;
import com.gs.spider.service.commons.spider.CommonsSpiderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * CommonsWebpageDownloadController
 *
 * @author Gao Shen
 * @version 16/4/8
 */
@Controller
@RequestMapping("/commons/spider")
public class CommonsSpiderController extends AsyncGatherBaseController {
    private Logger LOG = LogManager.getLogger(CommonsSpiderController.class);
    private CommonsSpiderService spiderService;

    @Autowired
    public CommonsSpiderController(@Qualifier("commonsSpiderService") AsyncGatherService asyncGatherService) {
        super(asyncGatherService);
        this.spiderService = (CommonsSpiderService) asyncGatherService;
    }

    /**
     * 启动爬虫
     *
     * @param spiderInfoJson 使用json格式进行序列化的spiderinfo
     * @return 任务id
     */
    @RequestMapping(value = "start", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json")
    @ResponseBody
    public ResultBundle<String> start(String spiderInfoJson) {
        return spiderService.start(spiderInfoJson);
    }

    /**
     * 停止爬虫
     *
     * @param uuid 任务id(爬虫uuid)
     * @return
     */
    @RequestMapping(value = "stop", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResultBundle<String> stop(String uuid) {
        return spiderService.stop(uuid);
    }

    /**
     * 获取爬虫运行时信息
     *
     * @param uuid 爬虫uuid 任务id
     * @return
     */
    @RequestMapping(value = "runtimeInfo", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResultBundle<Map<Object, Object>> runtimeInfo(String uuid, @RequestParam(value = "containsExtraInfo", required = false, defaultValue = "false") boolean containsExtraInfo) {
        return spiderService.runtimeInfo(uuid, containsExtraInfo);
    }

    /**
     * 列出所有爬虫的运行时信息
     *
     * @return
     */
    @RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResultBundle<Map<String, Map<Object, Object>>> list(@RequestParam(value = "containsExtraInfo", required = false, defaultValue = "false") boolean containsExtraInfo) {
        return spiderService.list(containsExtraInfo);
    }

    /**
     * 删除爬虫
     *
     * @param uuid 爬虫uuid 任务id
     * @return
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResultBundle<String> delete(String uuid) {
        return spiderService.delete(uuid);
    }

    /**
     * 删除所有爬虫
     *
     * @return
     */
    @RequestMapping(value = "deleteAll", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResultBundle<String> deleteAll() {
        return spiderService.deleteAll();
    }

    /**
     * 测试爬虫模板
     *
     * @param spiderInfoJson
     * @return
     */
    @RequestMapping(value = "testSpiderInfo", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResultListBundle<Webpage> testSpiderInfo(String spiderInfoJson) {
        return spiderService.testSpiderInfo(spiderInfoJson);
    }

    /**
     * 获取忽略url黑名单
     *
     * @return
     */
    @RequestMapping(value = "getIgnoredUrls", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResultListBundle<String> getIgnoredUrls() {
        return spiderService.getIgnoredUrls();
    }

    /**
     * 添加忽略url黑名单
     *
     * @param postfix
     */
    @RequestMapping(value = "addIgnoredUrl", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResultBundle<String> addIgnoredUrl(String postfix) {
        return spiderService.addIgnoredUrl(postfix);
    }
}
