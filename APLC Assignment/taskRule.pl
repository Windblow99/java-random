bubble_sort(List,Sorted):-b_sort(List,[],Sorted).
b_sort([],Acc,Acc).
b_sort([H|T],Acc,Sorted):-bubble(H,T,NT,Max),b_sort(NT,[Max|Acc],Sorted).
   
bubble(X,[],[],X).
bubble(X,[Y|T],[Y|NT],Max):-Y>X,bubble(X,T,NT,Max).
bubble(X,[Y|T],[X|NT],Max):-Y=<X,bubble(Y,T,NT,Max).