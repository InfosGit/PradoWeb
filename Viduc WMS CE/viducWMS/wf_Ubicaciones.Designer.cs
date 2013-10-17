namespace viducWMS
{
    partial class wf_Ubicaciones
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.txtConfirUbicacion = new System.Windows.Forms.TextBox();
            this.dgUbicaciones = new System.Windows.Forms.DataGrid();
            this.btnSalir = new System.Windows.Forms.Button();
            this.txtUbicacion = new System.Windows.Forms.TextBox();
            this.lblUbicacion = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtUnidades = new System.Windows.Forms.TextBox();
            this.lblTitle = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.txtProducto = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // txtConfirUbicacion
            // 
            this.txtConfirUbicacion.BackColor = System.Drawing.Color.White;
            this.txtConfirUbicacion.Location = new System.Drawing.Point(114, 240);
            this.txtConfirUbicacion.Name = "txtConfirUbicacion";
            this.txtConfirUbicacion.Size = new System.Drawing.Size(120, 21);
            this.txtConfirUbicacion.TabIndex = 2;
            this.txtConfirUbicacion.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtConfirUbicacion_KeyUp);
            // 
            // dgUbicaciones
            // 
            this.dgUbicaciones.BackColor = System.Drawing.Color.White;
            this.dgUbicaciones.BackgroundColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.dgUbicaciones.Location = new System.Drawing.Point(5, 63);
            this.dgUbicaciones.Name = "dgUbicaciones";
            this.dgUbicaciones.Size = new System.Drawing.Size(230, 130);
            this.dgUbicaciones.TabIndex = 6;
            this.dgUbicaciones.CurrentCellChanged += new System.EventHandler(this.dgUbicaciones_CurrentCellChanged);
            this.dgUbicaciones.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.dgUbicaciones_KeyPress);
            this.dgUbicaciones.KeyUp += new System.Windows.Forms.KeyEventHandler(this.dgUbicaciones_KeyUp);
            this.dgUbicaciones.Click += new System.EventHandler(this.dgUbicaciones_Click);
            // 
            // btnSalir
            // 
            this.btnSalir.BackColor = System.Drawing.Color.Navy;
            this.btnSalir.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.btnSalir.ForeColor = System.Drawing.Color.White;
            this.btnSalir.Location = new System.Drawing.Point(151, 263);
            this.btnSalir.Name = "btnSalir";
            this.btnSalir.Size = new System.Drawing.Size(83, 30);
            this.btnSalir.TabIndex = 3;
            this.btnSalir.Text = "Cancelar";
            this.btnSalir.Click += new System.EventHandler(this.btnSalir_Click);
            // 
            // txtUbicacion
            // 
            this.txtUbicacion.BackColor = System.Drawing.Color.White;
            this.txtUbicacion.Location = new System.Drawing.Point(114, 196);
            this.txtUbicacion.Name = "txtUbicacion";
            this.txtUbicacion.Size = new System.Drawing.Size(120, 21);
            this.txtUbicacion.TabIndex = 0;
            this.txtUbicacion.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtUbicacion_KeyUp);
            // 
            // lblUbicacion
            // 
            this.lblUbicacion.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.lblUbicacion.ForeColor = System.Drawing.Color.Navy;
            this.lblUbicacion.Location = new System.Drawing.Point(46, 200);
            this.lblUbicacion.Name = "lblUbicacion";
            this.lblUbicacion.Size = new System.Drawing.Size(62, 18);
            this.lblUbicacion.Text = "Ubicación:";
            // 
            // label2
            // 
            this.label2.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label2.ForeColor = System.Drawing.Color.Navy;
            this.label2.Location = new System.Drawing.Point(48, 223);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(59, 17);
            this.label2.Text = "Unidades:";
            // 
            // txtUnidades
            // 
            this.txtUnidades.BackColor = System.Drawing.Color.White;
            this.txtUnidades.Location = new System.Drawing.Point(114, 218);
            this.txtUnidades.Name = "txtUnidades";
            this.txtUnidades.Size = new System.Drawing.Size(120, 21);
            this.txtUnidades.TabIndex = 1;
            this.txtUnidades.KeyUp += new System.Windows.Forms.KeyEventHandler(this.txtUnidades_KeyUp);
            this.txtUnidades.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtUnidades_KeyPress);
            // 
            // lblTitle
            // 
            this.lblTitle.Anchor = ((System.Windows.Forms.AnchorStyles)((((System.Windows.Forms.AnchorStyles.Top | System.Windows.Forms.AnchorStyles.Bottom)
                        | System.Windows.Forms.AnchorStyles.Left)
                        | System.Windows.Forms.AnchorStyles.Right)));
            this.lblTitle.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.lblTitle.ForeColor = System.Drawing.Color.Navy;
            this.lblTitle.Location = new System.Drawing.Point(4, 39);
            this.lblTitle.Name = "lblTitle";
            this.lblTitle.Size = new System.Drawing.Size(189, 13);
            this.lblTitle.Text = "Listado de ubicaciones sugeridas";
            this.lblTitle.TextAlign = System.Drawing.ContentAlignment.TopCenter;
            // 
            // label1
            // 
            this.label1.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.label1.ForeColor = System.Drawing.Color.Navy;
            this.label1.Location = new System.Drawing.Point(8, 243);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(101, 14);
            this.label1.Text = "Confir. ubicación:";
            // 
            // txtProducto
            // 
            this.txtProducto.Font = new System.Drawing.Font("Tahoma", 8F, System.Drawing.FontStyle.Bold);
            this.txtProducto.Location = new System.Drawing.Point(5, 1);
            this.txtProducto.Multiline = true;
            this.txtProducto.Name = "txtProducto";
            this.txtProducto.ReadOnly = true;
            this.txtProducto.Size = new System.Drawing.Size(231, 32);
            this.txtProducto.TabIndex = 19;
            // 
            // wf_Ubicaciones
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(96F, 96F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Dpi;
            this.AutoScroll = true;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(128)))), ((int)(((byte)(192)))), ((int)(((byte)(255)))));
            this.ClientSize = new System.Drawing.Size(240, 294);
            this.Controls.Add(this.txtProducto);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtConfirUbicacion);
            this.Controls.Add(this.txtUnidades);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lblUbicacion);
            this.Controls.Add(this.txtUbicacion);
            this.Controls.Add(this.btnSalir);
            this.Controls.Add(this.lblTitle);
            this.Controls.Add(this.dgUbicaciones);
            this.Name = "wf_Ubicaciones";
            this.Text = "Ubicaciones disponibles";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGrid dgUbicaciones;
        private System.Windows.Forms.Button btnSalir;
        private System.Windows.Forms.TextBox txtUbicacion;
        private System.Windows.Forms.Label lblUbicacion;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtUnidades;
        private System.Windows.Forms.Label lblTitle;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox txtProducto;
        private System.Windows.Forms.TextBox txtConfirUbicacion;
    }
}