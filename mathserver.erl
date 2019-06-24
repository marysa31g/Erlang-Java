-module(mathserver).
-export([start/0,add/2]). 
start()->
Pid=spawn(fun()->loop()end),
register(mathserver,Pid).
loop()->
receive 
	{From,{add,First,Second}}->
	From !{mathserver,First+Second},
	loop() end.
add(First,Second)->mathserver!{self(),{add,First,Second}},
receive 
	{mathserver,Reply} ->
	 io:format("Resultado de suma:~p~n",[Reply]) 
	end.
