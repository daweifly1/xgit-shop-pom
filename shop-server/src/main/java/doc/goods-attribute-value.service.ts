export interface GoodsAttributeValueReqModel {
        // pk
        id?:  number;
        // 商品id
        productId?:  number;
        // 商品属性id
        productAttributeId?:  number;
        // 手动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
        value?: string;
        // 创建人
        dbCreateAuthor?: string;
        // 创建时间
        dbCreateTime?: Date;
        // 更新人
        dbUpdateAuthor?: string;
        // 更新时间
        dbUpdateTime?: Date;
}

##############################################################################################

import { Injectable, Injector } from '@angular/core';
import { HttpUtilNs, HttpUtilService } from '../infra/http/http-util.service';
import { Observable } from 'rxjs/Observable';
export namespace GoodsAttributeValueServiceNs {
    export interface UfastHttpResT<T> extends HttpUtilNs.UfastHttpResT<T> {
    }
    export class GoodsAttributeValueServiceClass {
        private http: HttpUtilService;
        private defaultConfig: HttpUtilNs.UfastHttpConfig;
        private barcodeFlagList: { value: number, label: string }[];
        private returnState: { value: number, label: string }[];
        constructor(private injector: Injector) {
            this.http = this.injector.get(HttpUtilService);
            this.defaultConfig = {
                gateway: HttpUtilNs.GatewayKey.Ss
            };
            this.barcodeFlagList = [
                { label: '否', value: 0 },
                { label: '是', value: 1 }
            ];
        }
        public getBarcodeList(): Observable<any> {
            return Observable.of(this.barcodeFlagList);
        }

        /**列表 */
        public getGoodsAttributeValueList(filter): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeValue/list', filter, this.defaultConfig);
        }

        /**新增保存 */
        public addSaveGoodsAttributeValue(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeValue/save', data, this.defaultConfig);
        }
        /**新增提交 */
        public addSubmitGoodsAttributeValue(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeValue/submit', data, this.defaultConfig);
        }
        /**详情 */
        public getGoodsAttributeValueDetail(id: string): Observable<UfastHttpResT<any>> {
            return this.http.Get<UfastHttpResT<any>>('/goodsAttributeValue/item', { id: id }, this.defaultConfig);
        }
        /**结单 */
        public finishGoodsAttributeValue(data): Observable<UfastHttpResT<any>> {
            return this.http.Post<UfastHttpResT<any>>('/goodsAttributeValue/endBill', data, this.defaultConfig);
        }
        /**删除 */
        public deletePurchaseOut(ids: any[]): Observable<UfastHttpResT<any>> {
            return this.http.Post('/goodsAttributeValue/delete', ids, this.defaultConfig);
        }
    }
}

@Injectable()
export class GoodsAttributeValueService extends GoodsAttributeValueServiceNs.GoodsAttributeValueServiceClass {
    constructor(injector: Injector) {
        super(injector);
    }
}

###########################################################################################

