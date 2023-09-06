package org.cacl;

import java.io.IOException;

public class RuntimePoc {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec(args[0]);
    }
}

//使用以下命令执行
//java Example "calc.exe"

//    java Example ";rm -rf /"
//则程序将调用操作系统执行 rm -rf / 命令，从而删除整个文件系统。这个命令将引起灾难性的后果，因此非常危险。
//为了避免这种安全风险，Java 程序应该对传递给程序的参数进行严格的验证和过滤。例如，可以使用正则表达式或其他验证方式，检查参数是否合法，并拒绝非法的参数。
//同时，程序应该使用最小权限原则，尽量减少执行操作系统命令的次数和范围，从而降低攻击风险。




