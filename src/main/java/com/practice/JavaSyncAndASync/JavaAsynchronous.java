package com.practice.JavaSyncAndASync;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Collections;
import java.util.concurrent.*;
import java.util.function.Supplier;

/**
 * Java异步
 *
 * 想象这样一个场景：你可能希望为你的法国客户提供指定主题的热点报道。
 * 为实现这一功能，你需要向 谷歌或者Twitter的API请求所有语言中针对该主题最热门的评论，
 * 可能还需要依据你的内部算法 对它们的相关性进行排序。
 * 之后，你可能还需要使用谷歌的翻译服务把它们翻译成法语，
 * 甚至 利用谷歌地图服务定位出评论作者的位置信息，最终将所有这些信息聚集起来，呈现在你的网站上。
 *
 * 需求:
 * 有可能出现由于某些外部网络服务发生响应慢的情况。在这种情况下，我们可能希望依旧能为用户提供部分信息，
 * 比如提供带问号标记的通用地图，以文本的方式显示信息，而不是呆呆地显示一片空白屏幕
 *
 *  要实现类似的服务，你需要与互联网上的多个Web服务通信。可是，你并不希望因为等待某 些服务的响应，
 *  阻塞应用程序的运行，浪费数十亿宝贵的CPU时钟周期。比如，不要因为等待 Facebook的数据，暂停对来自Twitter的数据处理。
 *
 * @author zhaoxu
 * @className JavaAsynchronous
 * @projectName JavaConcentration
 * @date 2020/12/13 17:38
 */
public class JavaAsynchronous {

//
//    ExecutorService executor = Executors.newSingleThreadExecutor();
//    ArchiveSearcher searcher =;
//    void showSearch(final String target) throws InterruptedException {
//        Collections.synchronizedMap(Maps.newHashMap());
//        Future<String> future
//                = executor.submit(new Callable<String>() {
//            public String call() {
//                return searcher.search(target);
//            }});
//        displayOtherThings(); // do other things while searching
//        try {
//            displayText(future.get()); // use future
//        } catch (ExecutionException ex) { cleanup(); return; }
//    }
}








