#include "Color.h"
#include "Red.h"
#include "Green.h"
#include"Blue.h"

Color* Color::getInstande(ColorType type){
  Color *ret = 0;
  if(type==RED){
    ret = new Red();
  }else if(type==GREEN){
    ret = new Green();
  }else if(type==BLUE){
    ret=new Blue();
  }
  return ret;
}
