package com.data.entity;

import java.util.List;

public class Page<T> {
    private final List<T> content;
    private final int totalNumberOfElements;
    private final int currentPageNumber;
    private final int maxElementsPerPage;

    public Page(List<T> content, int totalNumberOfElements, int currentPageNumber, int maxElementsPerPage) {
        this.content = content;
        this.totalNumberOfElements = totalNumberOfElements;
        this.currentPageNumber = currentPageNumber;
        this.maxElementsPerPage = maxElementsPerPage;
    }

    public List<T> getContent() {
        return content;
    }

    public int getTotalNumberOfElements() {
        return totalNumberOfElements;
    }

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public int getMaxElementsPerPage() {
        return maxElementsPerPage;
    }
}
