package com.eCommerce.dream.dto.sale;

import com.eCommerce.dream.domain.Client;
import com.eCommerce.dream.domain.ProductSale;
import com.eCommerce.dream.domain.Sale;
import com.eCommerce.dream.enums.SaleStatus;
import com.eCommerce.dream.repository.ProductSaleRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleDetailDTO {

    private Integer totalProducts;
    private Double amountSale;
    private LocalDateTime dataSale;
    private List<ProductSale> products;
    private Client client;
    private SaleStatus saleStatus;

    public SaleDetailDTO(Sale sale, ProductSaleRepository repository) {
        this.products = getSaleProduts(sale.getProductSalesId(), repository);
        this.client = sale.getClient();
        this.amountSale = sale.getAmount();
        this.dataSale = sale.getDataSale();
        this.totalProducts = sale.getProductSalesId().size();
        this.saleStatus = sale.getSaleStatus();
    }

    public Double getAmountSale() {
        return amountSale;
    }

    public void setAmountSale(Double amountSale) {
        this.amountSale = amountSale;
    }

    public LocalDateTime getDataSale() {
        return dataSale;
    }

    public void setDataSale(LocalDateTime dataSale) {
        this.dataSale = dataSale;
    }

    public List<ProductSale> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSale> products) {
        this.products = products;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Integer totalProducts) {
        this.totalProducts = totalProducts;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    public List<ProductSale> getSaleProduts(List<ProductSale> productsSale, ProductSaleRepository repository){

        List<ProductSale> productsSold = new ArrayList<>();
        productsSale.forEach(prod -> productsSold.add(repository.findById(prod.getId()).get()));

        return productsSold;
    }
}
