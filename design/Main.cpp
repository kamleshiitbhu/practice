#include "Color.h"
int main(void){
  Color *cl = Color::getInstande(BLUE);
  cl->display();
}
