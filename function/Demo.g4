
grammar Demo;

prog: ( (stat|function|block)? NEWLINE )*
;

stat:	WRITE value				#write
    | REPEAT repetitions block ENDREPEAT	#repeat
	| IF equal THEN blockif ENDIF           #if
	| ID '=' value				#assign
	| ID '=' expr               #expres
	| READ ID   				#read
	| ID    				#call
;

repetitions: value
;

expr: value ADD expr		#add
    | value MINUS expr #minus
	| value			#single
   ;

REPEAT:	'repeat'
;

ENDREPEAT: 'endrepeat'
;

blockif: block
;

equal: ID '==' INT
;

IF:	'if'
;

THEN:	'then'
;

ENDIF:	'endif'
;

function: FUNCTION fparam fblock ENDFUNCTION
;

fparam: ID
;

block: ( stat? NEWLINE )* 
; 

fblock: ( stat? NEWLINE )* 
; 

value: INT
	| ID
;

ADD: '+'
    ;

MINUS: '-'
    ;

WRITE:	'write' 
;

READ:	'read' 
;

FUNCTION: 'function'
;

ENDFUNCTION:	'endfunction'
;

ID:   ('a'..'z'|'A'..'Z')+
;

INT:   '0'..'9'+
;

NEWLINE:	'\r'? '\n'
;

WS:   (' '|'\t')+ { skip(); }
;
