declare i32 @printf(i8*, ...)
declare i32 @__isoc99_scanf(i8*, ...)
@strp = constant [4 x i8] c"%d\0A\00"
@strs = constant [3 x i8] c"%d\00"
@x = global i32 0
define i32 @funONE() nounwind {
%1 = load i32, i32* @x
%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %1)
%x = alloca i32
store i32 2, i32* %x
%3 = load i32, i32* %x
%funONE = alloca i32
store i32 %3, i32* %funONE
%4 = load i32, i32* %funONE
ret i32 %4
}
@a = global i32 0
define i32 @funTWO() nounwind {
%zmLOC = alloca i32
store i32 3, i32* %zmLOC
%1 = load i32, i32* %zmLOC
%funTWO = alloca i32
store i32 %1, i32* %funTWO
%2 = load i32, i32* %funTWO
ret i32 %2
}
@b = global i32 0
@z = global i32 0
@y = global i32 0
@c = global i32 0
@k = global i32 0
define i32 @main() nounwind{
%1 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* @x)
%2 = call i32 @funONE()
store i32 %2, i32* @a
%3 = load i32, i32* @a
%4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %3)
%5 = call i32 @funTWO()
store i32 %5, i32* @b
%6 = load i32, i32* @b
%7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %6)
store i32 4, i32* @z
store i32 5, i32* @y
%8 = load i32, i32* @z
%9 = icmp eq i32 %8, 4
br i1 %9, label %true1, label %false1
true1:
%10 = load i32, i32* @z
%11 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %10)
%12 = load i32, i32* @y
%13 = icmp eq i32 %12, 5
br i1 %13, label %true2, label %false2
true2:
%14 = load i32, i32* @y
%15 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %14)
%16 = call i32 @funTWO()
store i32 %16, i32* @c
%17 = load i32, i32* @c
%18 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %17)
br label %false2
false2:
br label %false1
false1:
store i32 6, i32* @k
%19 = load i32, i32* @k
%20 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %19)
%21 = load i32, i32* @k
%22 = icmp eq i32 %21, 7
br i1 %22, label %true3, label %false3
true3:
%23 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 777)
br label %false3
false3:
%24 = alloca i32
store i32 0, i32* %24
br label %cond4
cond4:
%25 = load i32, i32* %24
%26 = add i32 %25, 1
store i32 %26, i32* %24
%27 = icmp slt i32 %25, 3
br i1 %27, label %true4, label %false4
true4:
%28 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 322)
%29 = load i32, i32* @a
%30 = alloca i32
store i32 0, i32* %30
br label %cond5
cond5:
%31 = load i32, i32* %30
%32 = add i32 %31, 1
store i32 %32, i32* %30
%33 = icmp slt i32 %31, %29
br i1 %33, label %true5, label %false5
true5:
%34 = load i32, i32* @a
%35 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strp, i32 0, i32 0), i32 %34)
br label %cond5
false5:
br label %cond4
false4:
ret i32 0 }
