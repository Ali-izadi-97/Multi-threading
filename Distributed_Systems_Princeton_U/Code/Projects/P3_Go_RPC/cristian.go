package main

import (
	"net/rpc"
	"time"
)

type CristianServer struct {
	addr string
}

type SyncRequest struct {}

type SyncResponse struct {
	T2	time.Time
	T3	time.Time
}

func (server *CristianServer) Listen() {
	rpc.Register(server)
	startListener(server.addr)
}

func (*CristianServer) GetTime(req SyncRequest, res *SyncResponse) error {
	res.T2 = time.Now()
	res.T3 = time.Now()
	return nil
}

func SyncTime(serverAddr string) (time.Time, error) {
	client, err := rpc.Dial("tcp", serverAddr)
	checkError(err)
	args := SyncRequest{}
	reply := SyncResponse{}
	t1 := time.Now()
	err = client.Call("CristianServer.GetTime", args, &reply)
	t4 := time.Now()
	if err != nil {
		return time.Now(), err
	}
	t2 := reply.T2
	t3 := reply.T3
	rtt := t4.Sub(t1) - t3.Sub(t2) // (t4 - t1) - (t3 - t2)
	return t3.Add(rtt / 2), nil
}
