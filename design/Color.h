#ifndef __COLOR_H__
#define __COLOR_H__
typedef enum{
  RED=0,
  BLUE,
  GREEN
}ColorType;

class Color{
public:
  virtual  void  display(void) = 0;
  static Color* getInstande(ColorType type);
};
#endif //__COLOR_H__
