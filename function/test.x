read x

function funONE
  write x
  x = 2
  funONE = x
endfunction

a = funONE
write a

function funTWO
  zmLOC = 3
  funTWO = zmLOC
endfunction

b = funTWO
write b

z = 4
y = 5

if z == 4 then
write z
    if y == 5 then
    write y
    c = funTWO
    write c
    endif
endif

write zmLOC

k = 6
write k

if k == 7 then
 write 777
endif

repeat 3
 write 322
 repeat a
  write a
 endrepeat
endrepeat


