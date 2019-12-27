package com.codegym.task.task37.task3708.retrievers;

import com.codegym.task.task37.task3708.cache.LRUCache;
import com.codegym.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    private LRUCache lruCache;
    private OriginalRetriever originalRetriever;
    Storage storage;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        this.originalRetriever = new OriginalRetriever(storage);
        this.lruCache=new LRUCache(10);
    }

    @Override
    public Object retrieve(long id) {
        Object result;
        if((result=lruCache.find(id))!=null) return result;
        else {
            result = originalRetriever.retrieve(id);
            lruCache.set(id,result);
            return result;
        }

    }
}
