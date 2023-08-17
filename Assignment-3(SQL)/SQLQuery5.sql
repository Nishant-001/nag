--Excercise 4

CREATE FUNCTION dbo.LineItemCurrencyExchange (
 @SalesOrderID INT,
 @TargetCurrencyCode nchar(3),
 @CurrencyRateDate DATETIME
)
RETURNS @OutTable TABLE (
 SalesOrderDetailID INT,
 OrderQty SMALLINT,
 ProductID INT,
 UnitPrice MONEY,
 UnitPriceConverted MONEY
)
AS
BEGIN
 DECLARE @EndOfDayRate MONEY;

 SELECT @EndOfDayRate = EndOfDayRate
 FROM Sales.CurrencyRate
 WHERE CurrencyRateDate = @CurrencyRateDate
 AND ToCurrencyCode = @TargetCurrencyCode;
 INSERT @OutTable
 SELECT SalesOrderDetailID,
 OrderQty,
 ProductID,
 UnitPrice,
 UnitPrice * @EndOfDayRate
 FROM Sales.SalesOrderDetail
 WHERE SalesOrderID = @SalesOrderID
 RETURN;
END
GO

SELECT *
FROM dbo.LineItemCurrencyExchange(43659,'EUR','2005-07-05 00:00:00.000');