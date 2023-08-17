--Excercise 1:
--Question 1:

select COUNT(*) as Count_Of_Persons from Sales.SalesPerson;

--Question 2:

SELECT FirstName
, LastName
FROM Person.Person
WHERE FirstName LIKE 'B%'; 

--Question 3:

SELECT Person.Person.FirstName
, Person.Person.LastName
, HumanResources.Employee.JobTitle
FROM Person.Person
INNER JOIN HumanResources.Employee ON(Person.BusinessEntityID=HumanResources.Employee.BusinessEntityID)
WHERE HumanResources.Employee.JobTitle='Design Engineer' OR 
HumanResources.Employee.JobTitle='Tool Designer' OR 
HumanResources.Employee.JobTitle='Marketing Assistant'
ORDER BY Person.FirstName
	, Person.LastName;


--Question 4:

SELECT Name
, Color
, weight
FROM Production.Product
WHERE Weight=(SELECT MAX(Weight) FROM Production.Product);


--Question 5:

SELECT Description
, ISNULL(MaxQty,0.00) AS MaxQty
FROM Sales.SpecialOffer;


--Question 6:

SELECT 
AVG(AverageRate) AS 'Average exchange rate for the day'
FROM Sales.CurrencyRate
WHERE FromCurrencyCode='USD' AND ToCurrencyCode='GBP'


--Question 7:

SELECT ROW_NUMBER() over (order by FirstName asc) As Row,FirstName,LastName
FROM Person.Person
where FirstName like '%ss%';


--Question 8:
select BusinessEntityID as SalesPersonID, 'Commission Band'= CASE WHEN CommissionPct = 0 then 'band 0'
when CommissionPct > 0 and CommissionPct <= 0.01 then 'band 1'
when CommissionPct > 0.01 and CommissionPct <= 0.015 then 'band 2'
when CommissionPct > 0.015 then 'band 3' END
FROM Sales.SalesPerson
order by CommissionPct


--Question 9:
SELECT Person.Person.BusinessEntityID, Person.Person.FirstName, Person.Person.MiddleName, 
Person.Person.LastName, HumanResources.EmployeePayHistory.Rate,                      
HumanResources.Employee.OrganizationLevel, HumanResources.Employee.JobTitle 
FROM HumanResources.Employee 
INNER JOIN
HumanResources.EmployeePayHistory ON HumanResources.Employee.BusinessEntityID = HumanResources.EmployeePayHistory.BusinessEntityID 
INNER JOIN
Person.Person ON HumanResources.Employee.BusinessEntityID = Person.Person.BusinessEntityID 
WHERE Person.person.BusinessEntityID<49                      
ORDER BY Person.person.BusinessEntityID ASC;


--Question 10:
SELECT ProductID,Quantity
FROM Production.ProductInventory
ORDER BY Quantity DESC;


