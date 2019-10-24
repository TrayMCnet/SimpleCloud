package eu.thesimplecloud.lib.network.packets.service

import eu.thesimplecloud.clientserverapi.lib.connection.IConnection
import eu.thesimplecloud.clientserverapi.lib.packet.IPacket
import eu.thesimplecloud.clientserverapi.lib.packet.packettype.ObjectPacket
import eu.thesimplecloud.lib.CloudLib

class PacketIOStartService() : ObjectPacket<String>(String::class.java) {

    constructor(name: String): this() {
        this.value = name
    }

    override suspend fun handle(connection: IConnection): IPacket? {
        val name = this.value ?: return null
        CloudLib.instance.getCloudServiceManger().getCloudService(name)?.start()
        return null
    }
}