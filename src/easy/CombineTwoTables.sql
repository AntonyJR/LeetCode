select p.FirstName as FirstName, p.LastName as LastName, a.City as City, a.State as State
from Person p
left outer join Address a
on p.PersonId = a.PersonId;