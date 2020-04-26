#Naymish Vaghela
#Programming Language Concepts
#Test 2


$x = 3;
$y = 4;
sub subfunc1 {
    return $x;
}
sub subfunc2 {
    return $y;
}
sub static {
    my $x = 2;
    print "The local value in static is: $x \n";
    return subfunc1();
}
sub dynamic {
    local $y = 10;
    print "The local value in dynamic is: $y \n";
    return subfunc2();
}



print "The statically scoped variable ", static(), "\n";


print "The dynamically scoped variable ", dynamic(), "\n";