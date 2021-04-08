function cak()
{

var nc=0,s,i;
var m=new Array(),n;

s=document.getElementById("ph").value;

for(i=0;i<s.length;i++)
if(s.charAt(i)==0||s.charAt(i)==1||s.charAt(i)==2||s.charAt(i)==3||s.charAt(i)==4||s.charAt(i)==5||s.charAt(i)==6||s.charAt(i)==7||s.charAt(i)==8||s.charAt(i)==9)
nc++;

if(s.length==10&&nc==10)
document.getElementById("span").textContent="Valid number";
if(s.length!=nc)
document.getElementById("span").textContent="only digits allowed in phone number";
if(s.length==nc&&nc!=10)
document.getElementById("span").textContent="phone no should be 10 digits";

m[0]="String length=";m[1]=s.length;m[2]="No of digits in string=";m[3]=nc;
n=m.join(" ");
document.getElementById("span0").textContent=n;
}