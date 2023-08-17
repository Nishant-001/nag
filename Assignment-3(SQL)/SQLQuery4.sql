--Excercise 3:

WITH MoreThan70k AS (
 SELECT CustomerID
 FROM Sales.SalesOrderHeader H
 GROUP BY CustomerID
 HAVING SUM(TotalDue) > 70000
), TopOrders AS (
SELECT H.CustomerID, H.SalesOrderID, H.OrderDate, H.TotalDue, ROW_NUMBER()
 OVER (PARTITION BY H.CustomerID ORDER BY OrderDate DESC) OrderRow
FROM Sales.SalesOrderHeader H
JOIN MoreThan70k M
 ON H.CustomerID = M.CustomerID
)
SELECT CustomerID, SalesOrderID, OrderDate, TotalDue
FROM TopOrders
WHERE OrderRow <= 5
ORDER BY CustomerID, OrderRow
