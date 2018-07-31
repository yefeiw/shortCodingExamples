Long sum = 20
def ints = 0..10
List output = []

ints.each {
   try {
       int cand = sum/it
       output.add(cand)
   } catch (Exception e) {
       e.printStackTrace()
   }
}

//The output will be [20,10,...etc] the zero will be omitted. Tested to be working
