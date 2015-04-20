package models.mzerek

import org.scalacheck.Properties
import org.scalacheck.Prop._
import org.scalacheck.Gen
import org.scalacheck.Arbitrary.arbitrary

object TestStringow extends Properties("StringiPolczenie") {

  //val threeStrings = Gen.oneOf("a", "bb", "ccc", "dddd", "eeeee")
  
  val stringi=arbitrary[String].suchThat(_.length>0)
  
  val biggerThanTwoString=stringi.filter(_.length>2)
  
  val genStrings = for{
    s1 <- biggerThanTwoString
    s2 <- biggerThanTwoString   
  }yield(s1,s2)

  property("s1.length+s2.length>s1.length") = forAll(genStrings) {
    pair =>      
      val s1 = pair._1
      val s2 = pair._2
      println(s"s1=$s1,s2=$s2")
      s1.length + s2.length > s1.length
    
  }

}