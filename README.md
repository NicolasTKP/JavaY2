# Class

## Edit
**purchaseOrders(String orderID, int column, String value)** -> Void

#Edit the purchase order txt file with the target of orderID, column representing the exact column to modify, value is the new value to replace the old value

## Matrix
**removeEmptyRows(String[][] matrix)** -> Clean Matrix

#Remove all rows with at least **one** empty value in **any** of the column

## Query
**anyMatchOrder(PurchaseOrder order, String keyword)** -> boolean value

#Check if any value of order match with keyword, the order datatype is PurchaseOrder object

## Search
**getUsername(String userID)** -> Username

#Query username with userid and return it

**getItemName(String itemID)** -> Item Name

#Query items with itemID and return item name

**getSupplierName(String supplierID)** -> Supplier Name

#Query suppliers with supplierID and return supplier name

# Object

## ObjectList
**PurchaseOrder Object**

#An object that store all information about purchase object except payment status

**getPurchaseOrders()** -> List of PurchaseOrder object

#Retrieve all purchase order from the purchase order txt file and return them as a list
