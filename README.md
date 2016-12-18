# Daemon
a simple and benifit daemon service

> 进程保活只能尽量保证进程不被杀死，不可能做到100%不被系统
由于某种原因干掉，`5.0`之前可以充分利用服务的优先级以及系统
的bug来实现一定级别的保活，`5.0`之后就不允许了，但是系统提供
了一个JobSchedule可以让开发实现保活的需求。
