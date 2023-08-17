--Excercise 5:

CREATE PROCEDURE person.NameInfo 
@Name varchar(50)
AS
SELECT FirstName,MiddleName,LastName
FROM Person.Person
WHERE FirstName=@Name;
GO



ALTER PROCEDURE person.NameInfo 
  @Name varchar(50) 
AS
IF @Name IS NULL BEGIN;
  SET @Name='Prithwish Dey'
END;
SELECT FirstName,MiddleName,LastName
FROM Person.Person
WHERE FirstName=@Name; 