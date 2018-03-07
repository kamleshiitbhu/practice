class Employee:
	def __init__(self,first,last,salary):
		self.first_name=first
		self.last_name=last
		self.salary=salary
		self.email=first[0] + '.' + last + '@samsung.com'
	def showEmail(self):
		return self.email
emp_1=Employee('kamlesh','jeengar','1300000')
print emp_1 .__dict__
x=int(emp_1.salary)+100000
print x