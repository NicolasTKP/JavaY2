# Class

## Edit
**purchaseOrders(String orderID, int column, String value)** -> Void

#Edit the purchase order txt file with the target of orderID, column representing the exact column to modify, value is the new value to replace the old value

**purchaseRequisitions(String requestID, int column, String value)** -> Void

#Edit the purchase requisitions txt file with the target of requestID, column representing the exact column to modify, value is the new value to replace the old value

**users(String userID, int column, String value)** -> Void

#Edit the user txt file with the target of userID

**inventory(String groupID, int column, String value)** -> Void

#Edit the inventory txt file with the target of groupID

**item(String itemID, int column, String value)** -> Void

#Edit the item txt file with the target of itemID

**supplier(String supplierID, int column, String value)** -> Void

#Edit the inventory txt file with the target of supplierID

**receives(String orderID, int column, String value)** -> Void

#Edit the inventory txt file with the target of orderID

**dailySalesItems(String dailySalesID, int column, String value)** -> Void

#Edit the inventory txt file with the target of dailySalesID

**removeItemForInventory(String supplierID, String itemID)** -> Void

#Remove an item from the inventory by targeting supplierID and itemID

**addItemForInventory(String supplierID, String itemID)** -> Void

#Add an item into inventory by inserting supplierID and itemID

**updateSalesTxt()** -> Void

#Update the sales txt with latest daily sales record

## Matrix
**removeEmptyRows(String[][] matrix)** -> Clean Matrix

#Remove all rows with at least **one** empty value in **any** of the column

## Query

**getLatestOrderID()** -> order ID

#Loop through the PO txt file and retrieve the latest unused order ID

**getPendingPR()** -> List of PR ID

#Return a list of PR ID which the PR status is Pending

**ifItemExist(String itemID)** -> boolean

#check if the item exist in inventory txt file by using itemID as target value

**ifUserExist(String username)** -> boolean

#check if the user exist in users txt file by using username as target value

## Search
**getUsername(String userID)** -> Username

#Query username with userid and return it

**getItemName(String itemID)** -> Item Name

#Query items with itemID and return item name

**getSupplierName(String supplierID)** -> Supplier Name

#Query suppliers with supplierID and return supplier name

**getUserID(String username)** -> User ID

#Query users with username and return user ID

**getFromPR(String requestID, int column)** -> specific column value from PR

#Retrieve a specific value in the selected column from PR txt file, target by request ID

**getFromInventory(String itemID, int column)** -> specific column value from inventory

#Retrieve a specific value in the selected column from inventory txt file, target by item ID

## TextFile

**addLine(String filePath, String line)** -> void

#Add a line to respective file path

**deleteLine(String filePath, String target, int targetColumn)** -> void

#Delete a line from respective file path with customize target and target column

## UpdateTable

**forPO(Jtable jtable)** -> void

#Update the jtable of purchase order

## ValidateFormat

**quantityUnit(String quantity)** -> boolean

#Validate format of quantity

**unitPrice(String unitPrice)** -> boolean

#Validate format of unit price

**date(String date)** -> boolean

#Validate format of date

# Object

## ObjectList
**PurchaseOrder Object**

#An object that store all information about purchase object except payment status

**getPurchaseOrders()** -> List of PurchaseOrder object

#Retrieve all purchase order from the purchase order txt file and return them as a list

## SessionManager

#Create a session and store user data

**getInstance()** -> Session

#Return a session. Create a session if it is not exist