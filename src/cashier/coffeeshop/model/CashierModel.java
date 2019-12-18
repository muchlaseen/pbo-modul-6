/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cashier.coffeeshop.model;

/**
 *
 * @author muchlas
 */
public class CashierModel {
    private int _itemId;
    private String _itemName;
    private int _itemPrice;
    private int _itemStock;
    private int totalSales;

    public int getItemId() {
        return _itemId;
    }

    public void setItemId(int _itemId) {
        this._itemId = _itemId;
    }

    public String getItemName() {
        return _itemName;
    }

    public void setItemName(String _itemName) {
        this._itemName = _itemName;
    }

    public int getItemPrice() {
        return _itemPrice;
    }

    public void setItemPrice(int _itemPrice) {
        this._itemPrice = _itemPrice;
    }

    public int getItemStock() {
        return _itemStock;
    }

    public void setItemStock(int _itemStock) {
        this._itemStock = _itemStock;
    }
    
    public void setTotalSales(int _itemPrice, int _itemStock) {
        totalSales = _itemPrice * _itemStock;
    }
    
    public int getTotalSales() {
        return totalSales;
    }
    
}
