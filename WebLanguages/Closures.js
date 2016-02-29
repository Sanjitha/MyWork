var outerValue = "ninja";
function outerFunction() {
    var innerValue = "samurai";
    function innerFunction()  {
        assert(outerValue,"I can see ninja");
        assert(innerValue,"I can see samurai");        
    }
    return innerFunction;
}