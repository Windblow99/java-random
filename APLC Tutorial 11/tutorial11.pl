% tutorial 11
& q1
find(X,[X|_]).
find(X,[_|Tail]) :- find(X,Tail).

% query
find(melon,[pears,tomatoes,apples,oranges]).

% q3
% facts
item(pen,9.9).
item(rule,3.9).
item(bag,58.9).
item(testpad,11.2).

% rule
find(Threshold) :- item(Name,Price), Price < Threshold, write (Name).

% query
find(10).

% q5
sum([],0).
sum([Head|Tail],R) :- sum(Tail,SumOfRest),R is Head+SumOfRest.

% query
sum([1,2,3], Result).