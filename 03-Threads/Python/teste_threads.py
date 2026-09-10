import threading
import time


class MinhaTarefa:
    @staticmethod
    def minha_tarefa(quantidade):
        t = threading.current_thread()
    for i in range(0, quantidade):
        print(f"Thread {t.name} | ID interno: {threading.get_ident()}")
        time.sleep(1)

obj = MinhaTarefa()
t1 = threading.Thread(target=MinhaTarefa, args=("A",), name="Tarefa-1")
t2 = threading.Thread(target=MinhaTarefa, args=("B",), name="Tarefa-2")

t1.start()
t2.start()
