package order;

import java.util.List;

public class OrderList {
    public java.util.List<Order> getCreatedOrders() {
        return orders;
    }

    public void setCreatedOrders(java.util.List<Order> orders) {
        this.orders = orders;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public java.util.List<AvailableStation> getAvailableStations() {
        return availableStations;
    }

    public void setAvailableStations(java.util.List<AvailableStation> availableStations) {
        this.availableStations = availableStations;
    }

    private java.util.List<Order> orders;
    private PageInfo pageInfo;
    private List<AvailableStation> availableStations;

    public OrderList(java.util.List<Order> orders, PageInfo pageInfo, java.util.List<AvailableStation> availableStations) {
        this.orders = orders;
        this.pageInfo = pageInfo;
        this.availableStations = availableStations;
    }

    public OrderList() {
    }
}